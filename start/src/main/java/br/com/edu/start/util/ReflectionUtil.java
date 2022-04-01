package br.com.edu.start.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Classe utilitária para os métodos de reflection.
 *
 * @author Eduardo
 *
 */
public final class ReflectionUtil {

    /**
     * LOGGER - Logger</br>
     */
    private static final Logger LOGGER = Logger.getLogger(ReflectionUtil.class);

    /**
     * 
     */
    private ReflectionUtil() {
        // N/A
    }

    /**
     * Copia os atributos de uma objeto de origem para o destino.
     * 
     * @param pSource
     * @param pDest
     */
    public static void copyObject(final Object pSource, final Object pDest) {
        LOGGER.debug("Iniciando a conversão de objetos");
        if ((pSource != null) && (pDest != null)) {
            copyObject(pSource, pDest, pSource.getClass());
        }
    }

    /**
     * 
     * @param pSource
     * @param pDest
     * @param pSourceClazz
     */
    private static void copyObject(final Object pSource, final Object pDest,
            final Class<? extends Object> pSourceClazz) {
        // Recupera os métodos declarados do objeto
        final Method[] methods = pSourceClazz.getDeclaredMethods();

        for (final Method method : methods) {
            final String methodName = method.getName();

            String fieldName = null;
            String methodSetName = null;
            if (methodName.startsWith("get") && (method.getParameterCount() == 0)) {
                fieldName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
                methodSetName = "set" + methodName.substring(3);
            }
            else if (methodName.startsWith("is")) {
                fieldName = methodName.substring(2);
                methodSetName = "set" + methodName.substring(2);
            }
            if ((fieldName != null) && !fieldName.isEmpty()) {
                final Object value = getValue(pSource, method);
                final Method methodSet = getMethod(pDest.getClass(), methodSetName, method.getReturnType());
                if ((methodSet != null) && (methodSet.getParameterCount() == 1)) {
                    invokeMethod(methodSet, pDest, value);
                }
            }
        }
    }

    /**
     * Recupera o valor do atributo pelo método do objeto.
     * 
     * @param pSource
     * @param pMethodName
     * @return
     */
    private static Object getValue(final Object pSource, final Method pMethodName) {
        Object value = null;
        try {
            value = pMethodName.invoke(pSource);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            LOGGER.error(error.getMessage());
        }
        return value;
    }

    /**
     * Retona o método do objeto.
     * 
     * @param pClazz
     * @param pMethodSetName
     * @param pReturnType
     * @return
     */
    private static Method getMethod(final Class<? extends Object> pClazz, final String pMethodSetName,
            final Class<? extends Object> pReturnType) {
        Method m = null;
        try {
            m = pClazz.getMethod(pMethodSetName, pReturnType);
        } catch (final NoSuchMethodException | SecurityException error) {
            LOGGER.error(error.getMessage());
        }
        return m;
    }

    /**
     * 
     * @param pMethodSet
     * @param pDest
     * @param pValue
     */
    private static void invokeMethod(final Method pMethodSet, final Object pDest, final Object pValue) {
        try {
            pMethodSet.invoke(pDest, pValue);
        } catch (final IllegalAccessException | IllegalArgumentException | InvocationTargetException error) {
            LOGGER.error(error.getMessage());
        }
    }

}