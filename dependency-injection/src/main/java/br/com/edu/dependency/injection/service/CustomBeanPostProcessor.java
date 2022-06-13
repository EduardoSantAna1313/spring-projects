package br.com.edu.dependency.injection.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(final Object bean, final String beanName) throws BeansException {

		if (bean instanceof LifecycleDemoBean) {
			((LifecycleDemoBean) bean).beforeInit();
		}

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(final Object bean, final String beanName) throws BeansException {
		if (bean instanceof LifecycleDemoBean) {
			((LifecycleDemoBean) bean).afterInit();
		}

		return bean;
	}
}
