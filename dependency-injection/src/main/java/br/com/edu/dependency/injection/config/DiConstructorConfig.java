/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.dependency.injection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@ConstructorBinding
@ConfigurationProperties("di")
public class DiConstructorConfig {

    private final String username;

    private final String password;

    private final String jdbcUrl;

    /**
     * Create a new instance of DiConstructorConfig
     *
     * @param username
     * @param password
     * @param jdbcUrl
     */
    public DiConstructorConfig(final String username, final String password, final String jdbcUrl) {
        super();
        this.username = username;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    /**
     * Retrieve the value of username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieve the value of password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieve the value of jdbcUrl.
     *
     * @return the jdbcUrl
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("DiConstructorConfig [username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", jdbcUrl=");
        builder.append(jdbcUrl);
        builder.append("]");
        return builder.toString();
    }

}
