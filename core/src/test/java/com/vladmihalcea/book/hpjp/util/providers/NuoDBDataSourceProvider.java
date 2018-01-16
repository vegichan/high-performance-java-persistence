package com.vladmihalcea.book.hpjp.util.providers;

import com.nuodb.hibernate.NuoDBDialect;

import javax.sql.DataSource;
import java.util.Properties;

import static com.nuodb.jdbc.DataSource.PROP_PASSWORD;
import static com.nuodb.jdbc.DataSource.PROP_SCHEMA;
import static com.nuodb.jdbc.DataSource.PROP_URL;
import static com.nuodb.jdbc.DataSource.PROP_USERNAME;

/**
 * @author Martin Kysel
 */
public class NuoDBDataSourceProvider implements DataSourceProvider {
    /** The default database username. */
    public static final String DEFAULT_SQL_USER = "dba";

    /** The default database user password */
    public static final String DEFAULT_SQL_PASSWORD = "dba";

    /** The root for any JDBC query URLs. */
    public static final String BASE_URL = "jdbc:com.nuodb://";

    /** The default database server name */
    public static final String DEFAULT_SERVER_NAME = "localhost";

    /** The default database name */
    public static final String DEFAULT_DATABASE_NAME = "test";

    /** The default database schema */
    public static final String DEFAULT_SCHEMA_NAME = "user";


	@Override
	public String hibernateDialect() {
		return NuoDBDialect.class.getName();
	}

	@Override
	public DataSource dataSource() {
	    Properties props = dataSourceProperties();
		DataSource dataSource = new com.nuodb.jdbc.DataSource(props);
		return dataSource;
	}

	@Override
	public Class<? extends DataSource> dataSourceClassName() {
		return com.nuodb.jdbc.DataSource.class;
	}

	@Override
	public Properties dataSourceProperties() {
        Properties properties = new Properties();
        properties.setProperty(PROP_USERNAME, DEFAULT_SQL_USER);
        properties.setProperty(PROP_PASSWORD, DEFAULT_SQL_PASSWORD);
        properties.setProperty(PROP_SCHEMA, DEFAULT_SCHEMA_NAME);

        properties.setProperty(PROP_URL, url());
		return properties;
	}

    @Override
    public String url() {
        return BASE_URL + DEFAULT_SERVER_NAME + "/" + DEFAULT_DATABASE_NAME;
    }

	@Override
	public String username() {
		return DEFAULT_SQL_USER;
	}

	@Override
	public String password() {
		return DEFAULT_SQL_PASSWORD;
	}

	@Override
	public Database database() {
		return Database.NUODB;
	}
}
