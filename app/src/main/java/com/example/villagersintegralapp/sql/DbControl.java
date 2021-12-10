package com.example.villagersintegralapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.villagersintegralapp.entity.UserEntity;

import java.util.List;

public class DbControl {

    private static DbControl mDbController;
    //Helper
    private DaoMaster.DevOpenHelper mHelper;//获取Helper对象
    //数据库

    private SQLiteDatabase db;
    //DaoMaster

    private final DaoMaster mDaoMaster;
    //DaoSession
    private final DaoSession mDaoSession;
    //上下文
    private final Context context;
    /*  *
     * dao
     */
    VillagersEntityDao dao;

    private UserEntity UserEntity;

    /* *
     * 初始化
     * @param context
     */
    public DbControl(Context context) {
        this.context = context;
        mHelper = new DaoMaster.DevOpenHelper(context, "villagers.db", null);
        mDaoMaster = new DaoMaster(getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
        dao = mDaoSession.getVillagersEntityDao();
    }

    /*  *
     * 获取单例
     */
    public static DbControl getInstance(Context context) {
        if (mDbController == null) {
            synchronized (DbControl.class) {
                if (mDbController == null) {
                    mDbController = new DbControl(context);
                }
            }
        }
        return mDbController;
    }

    /*  *
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(context, "person.db", null);
        }
        SQLiteDatabase db = mHelper.getReadableDatabase();
        return db;
    }

    /* *
     * 获取可写数据库
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        if (mHelper == null) {
            mHelper = new DaoMaster.DevOpenHelper(context, "person.db", null);
        }
        SQLiteDatabase db = mHelper.getWritableDatabase();
        return db;
    }

    /* *
     * 会自动判定是插入还是替换
     * @param UserEntity
     */
    public void insertOrReplace(VillagersEntity villagers) {
        dao.insertOrReplace(villagers);
    }

    /*  *插入一条记录，表里面要没有与之相同的记录
     *
     * @param UserEntity
     */
    public long insert(VillagersEntity villagers) {
        return dao.insert(villagers);
    }

    /* *
      * 更新数据
      * @param
 com.example.villagersintegralapp.entity.UserEntity
      */
    public void update(VillagersEntity villagers) {
        VillagersEntity mOldUserEntity = dao.queryBuilder().where(VillagersEntityDao.Properties.Id.eq(villagers.getId())).build().unique();//拿到之前的记录
        if (mOldUserEntity != null) {
            mOldUserEntity.setName("张三");
            dao.update(mOldUserEntity);
        }
    }

    /*  *
     * 按条件查询数据
     */
    public List<VillagersEntity> searchByWhere(String wherecluse) {
        List<VillagersEntity> list = (List<VillagersEntity>) dao.queryBuilder().where(VillagersEntityDao.Properties.Name.eq(wherecluse)).build().list();
        return list;
    }

    /* *
     * 查询所有数据
     */
    public List<VillagersEntity> searchAll() {
        List<VillagersEntity> list = dao.queryBuilder().list();
        return list;
    }

    /* *
     * 删除数据
     */
    public void delete(String wherecluse) {
        dao.queryBuilder().where(VillagersEntityDao.Properties.Name.eq(wherecluse)).buildDelete().executeDeleteWithoutDetachingEntities();
    }
}
