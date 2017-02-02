package com.vo2group.zoo.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.vo2group.zoo.model.Category;

import java.util.ArrayList;
import java.util.List;

public class ZooDatabase  extends SQLiteAssetHelper {
    private static final String TAG = ZooDatabase.class.getSimpleName();

    //region Database and version
    private static final String DATABASE_NAME = "ZooDatabase.sqlite";
    private static final int DATABASE_VERSION = 1;
    //endregion

    //region tables
    private static final String ANIMAL_TABLE = "Animal";
    private static final String[] ANIMAL_COLUMN = new String[]{ "Id", "Name", "BirthDay", "PictureUrl", "Category_Id" };

    private static final String CATEGORY_TABLE = "Category";
    private static final String[] CATEGORY_COLUMN = new String[]{ "Id", "Name" };
    //endregion

    private SQLiteDatabase database;

    public ZooDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.database = getWritableDatabase();
        database.execSQL("PRAGMA foreign_keys=ON;");
    }

    @Override
    protected void finalize() throws Throwable
    {
        this.close();
        Log.i(TAG, "databae closed");

        super.finalize();
    }

    //region Category
    /**
     * Return all Categories
     * @return
     */
    public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();


        Cursor cursor = this.database.query(CATEGORY_TABLE, CATEGORY_COLUMN, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            categories.add(cursorToAlert(cursor));
            cursor.moveToNext();
        }
        cursor.close();

        return categories;
    }

    /**
     * Transforme a data row to category
     * @param cursor the data row
     * @return an category
     */
    private Category cursorToAlert(Cursor cursor) {

        if (cursor.getCount() == 0)
            return null;

        Category category = new Category();

        category.setId(cursor.getLong(cursor.getColumnIndex("Id")));
        category.setName(cursor.getString(cursor.getColumnIndex("Name")));

        return category;
    }
    //endregion
}
