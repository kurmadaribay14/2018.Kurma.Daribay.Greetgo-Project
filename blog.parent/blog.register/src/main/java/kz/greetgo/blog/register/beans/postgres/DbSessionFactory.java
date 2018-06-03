package kz.greetgo.blog.register.beans.postgres;

import kz.greetgo.blog.register.config.DbConfig;
import kz.greetgo.blog.register.util.LocalSessionFactory;
import kz.greetgo.db.InTransaction;
import kz.greetgo.depinject.core.Bean;
import kz.greetgo.depinject.core.BeanGetter;
import kz.greetgo.depinject.core.replace.ReplaceWithAnn;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

@Bean
@ReplaceWithAnn(InTransaction.class)
public class DbSessionFactory extends LocalSessionFactory {

  public BeanGetter<DbConfig> dbConfig;

  @Override
  protected DataSource createDataSource() {
    BasicDataSource pool = new BasicDataSource();

    pool.setDriverClassName("org.postgresql.Driver");
    pool.setUrl(dbConfig.get().url());
    pool.setUsername(dbConfig.get().username());
    pool.setPassword(dbConfig.get().password());

    pool.setInitialSize(0);

    return pool;
  }

  @Override
  protected String databaseEnvironmentId() {
    return "DB_OPER";
  }

}
