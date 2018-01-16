package com.vladmihalcea.book.hpjp.jdbc.transaction.phenomena;

import com.vladmihalcea.book.hpjp.util.providers.DataSourceProvider;
import com.vladmihalcea.book.hpjp.util.providers.NuoDBDataSourceProvider;
import com.vladmihalcea.book.hpjp.util.providers.OracleDataSourceProvider;
import org.junit.runners.Parameterized;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * NuoDBPhenomenaTest - Test to validate NuoDB phenomena
 *
 * @author Martin Kysel
 */
public class NuoDBPhenomenaTest extends AbstractPhenomenaTest {

    public NuoDBPhenomenaTest(String isolationLevelName, int isolationLevel) {
        super(isolationLevelName, isolationLevel);
    }

    @Override
    protected DataSourceProvider dataSourceProvider() {
        return new NuoDBDataSourceProvider();
    }
}
