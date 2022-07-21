package co.dynamicts.neli.core.local.service;

import co.dynamicts.neli.core.utilities.Tools;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteDatabaseType;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Service {
  private ConnectionSource connectionSource = null;
  
  public Service() throws SQLException, ClassNotFoundException {
    connect(Tools.getSQLiteSDN("sky.sqlite"));
  }
  
  private void connect(String sdn) throws SQLException, ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");
    this.connectionSource = new JdbcConnectionSource(sdn, new SqliteDatabaseType());
  }
  
  public void createTableIfNotExists(Class classDefinition) throws SQLException {
    TableUtils.createTableIfNotExists(this.connectionSource, classDefinition);
  }
  
  public void close() {
    try {
      if (this.connectionSource != null)
        this.connectionSource.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  
  public List getList(Class clazz) throws SQLException {
    Dao<Object, ?> objectDao = DaoManager.createDao(this.connectionSource, clazz);
    return objectDao.queryForAll();
  }
  
  public Object getById(Class clazz, Object aId) throws SQLException {
    Dao<Object, Object> dao = DaoManager.createDao(this.connectionSource, clazz);
    return dao.queryForId(aId);
  }
  
  public Object getByCode(Class clazz, Object code) throws SQLException {
    Dao<Object, Object> dao = DaoManager.createDao(this.connectionSource, clazz);
    List<Object> datos = dao.queryForEq("code", code);
    if (datos != null && datos.size() > 0)
      return datos.get(0); 
    return null;
  }
  
  public Object getRandom(Class clazz) throws SQLException {
    Dao<Object, Object> dao = DaoManager.createDao(this.connectionSource, clazz);
    return dao.queryBuilder().orderByRaw("RANDOM()").limit(Long.valueOf(1L)).queryForFirst();
  }
  
  public Object create(Object obj) throws SQLException {
    Dao<Object, ?> dao = DaoManager.createDao(this.connectionSource, (Class<Object>) obj.getClass());
    return dao.createIfNotExists(obj);
  }
  
  public Object update(Object obj) throws SQLException {
    Dao<Object, ?> dao = DaoManager.createDao(this.connectionSource, (Class<Object>) obj.getClass());
    return Integer.valueOf(dao.update(obj));
  }
  
  public Dao.CreateOrUpdateStatus createOrUpdate(Object obj) throws SQLException {
    Dao<Object, ?> dao = DaoManager.createDao(this.connectionSource, (Class<Object>) obj.getClass());
    return dao.createOrUpdate(obj);
  }
  
  public int deleteById(Class clazz, Object aId) throws SQLException {
    Dao<Object, Object> dao = DaoManager.createDao(this.connectionSource, clazz);
    return dao.deleteById(aId);
  }
}


/* Location:              G:\Emulador\Emulator V 1.2.5.jar!\co\dynamicts\neli\core\local\service\Service.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */