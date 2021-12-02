package com.example.villagersintegralapp.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.villagersintegralapp.entity.UserEntity;

import java.util.List;

public class DbControl {
       /* *//**
         * Helper
         *//*
        private DaoMaster.DevOpenHelper mHelper;//获取Helper对象
        *//**
         * 数据库
         *//*
        private SQLiteDatabase db;
        *//**
         * DaoMaster
         *//*
        private DaoMaster mDaoMaster;
        *//**
         * DaoSession
         *//*
        private DaoSession mDaoSession;
        *//**
         * 上下文
         *//*
        private Context context;
        *//**
         * dao
         *//*
        private UserEntity UserEntity;

        private static DbControl mDbController;

        *//**
         * 获取单例
         *//*
        public static DbControl getInstance(Context context){
            if(mDbController == null){
                synchronized (DbControl.class){
                    if(mDbController == null){
                        mDbController = new DbControl(context);
                    }
                }
            }
            return mDbController;
        }
        *//**
         * 初始化
         * @param context
         *//*
        public DbControl(Context context) {
            this.context = context;
            mHelper = new DaoMaster.DevOpenHelper(context,"user.db", null);
            mDaoMaster =new DaoMaster(getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();
            dao = mDaoSession.getUserEntity();
        }
        *//**
         * 获取可读数据库
         *//*
        private SQLiteDatabase getReadableDatabase(){
            if(mHelper == null){
                mHelper = new DaoMaster.DevOpenHelper(context,"person.db",null);
            }
            SQLiteDatabase db =mHelper.getReadableDatabase();
            return db;
        }

        *//**
         * 获取可写数据库
         * @return
         *//*
        private SQLiteDatabase getWritableDatabase(){
            if(mHelper == null){
                mHelper =new DaoMaster.DevOpenHelper(context,"person.db",null);
            }
            SQLiteDatabase db = mHelper.getWritableDatabase();
            return db;
        }

        *//**
         * 会自动判定是插入还是替换
         * @param UserEntity
         *//*
        public void insertOrReplace(UserEntity UserEntity){
            UserEntity.insertOrReplace(UserEntity);
        }
        *//**插入一条记录，表里面要没有与之相同的记录
         *
         * @param UserEntity
         *//*
        public long insert(UserEntity user){
            return  UserEntity.insert(UserEntity);
        }

        *//**
         * 更新数据
         * @param UserEntity
         *//*
        public void update(UserEntity user){
            UserEntity mOldUserEntity = UserEntity.queryBuilder().where(UserEntity.Properties.Id.eq(UserEntity.getId())).build().unique();//拿到之前的记录
            if(mOldUserEntity !=null){
                mOldUserEntity.setName("张三");
                UserEntity.update(mOldUserEntity);
            }
        }
        *//**
         * 按条件查询数据
         *//*
        public List<UserEntity> searchByWhere(String wherecluse){
            List<UserEntity>UserEntitys = (List<UserEntity>) UserEntity.queryBuilder().where(UserEntity.Properties.Name.eq(wherecluse)).build().unique();
            return UserEntitys;
        }
        *//**
         * 查询所有数据
         *//*
        public List<UserEntity> searchAll(){
            List<UserEntity> UserEntitys=UserEntity.queryBuilder().list();
            return UserEntitys;
        }
        *//**
         * 删除数据
         *//*
        public void delete(String wherecluse){
            UserEntity.queryBuilder().where(UserEntity.Properties.Name.eq(wherecluse)).buildDelete().executeDeleteWithoutDetachingEntities();
        }*/
}
