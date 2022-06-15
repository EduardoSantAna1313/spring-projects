/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.dependency.injection.datasource;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class FakeDataSource {

    private String username;

    private String password;

    private String jdbcUrl;

    /**
     * Retrieve the value of username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set a new value to username.
     *
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
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
     * Set a new value to password.
     *
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Retrieve the value of jdbcUrl.
     *
     * @return the jdbcUrl
     */
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    /**
     * Set a new value to jdbcUrl.
     *
     * @param jdbcUrl the jdbcUrl to set
     */
    public void setJdbcUrl(final String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("FakeDataSource [username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", jdbcUrl=");
        builder.append(jdbcUrl);
        builder.append("]");
        return builder.toString();
    }

}
