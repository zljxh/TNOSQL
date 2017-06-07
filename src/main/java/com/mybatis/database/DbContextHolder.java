package com.mybatis.database;

/**
 * Created by user on 2017/6/7.
 */
public class DbContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    /**
     * ���õ�ǰ���ݿ⡣
     * @param dbType
     */
    public static void setDbType(String dbType)
    {
        contextHolder.set(dbType);
    }

    /**
     * ȡ�õ�ǰ����Դ��
     * @return
     */
    public static String getDbType()
    {
        String str = (String) contextHolder.get();
        return str;
    }

    /**
     * �������������
     */
    public static void clearDbType()
    {
        contextHolder.remove();
    }

}
