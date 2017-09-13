package br.com.fabricadeprogramador.fdpapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viniciuspodi on 06/09/17.
 */

public class BancoDeDados extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "fdpdb";
    public static final int VERSAO_BANCO = 1;

    public BancoDeDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE tbpessoa (id integer primary key, nome text, telefone text, email text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS tbpessoa";
        db.execSQL(sql);
        onCreate(db);
    }

    public List<Pessoa> buscarTodos(){
        SQLiteDatabase db = this.getWritableDatabase();

        List<Pessoa> lista = new ArrayList<>();
        String sql = "SELECT * FROM tbpessoa";

        Cursor cursor = db.rawQuery(sql, null);

        if( cursor.moveToFirst() ){

            do{
                Pessoa pessoa = new Pessoa();

                pessoa.setId(cursor.getLong(0));
                pessoa.setNome(cursor.getString(1));
                pessoa.setTelefone(cursor.getString(2));
                pessoa.setEmail(cursor.getString(3));

                lista.add(pessoa);
            } while(cursor.moveToNext());
        }

        db.close();
        return lista;
    }

    public Pessoa buscarPorId(int id){

        SQLiteDatabase db = this.getWritableDatabase();

        String sql = "SELECT * FROM tbpessoa WHERE id = " + id;

        Cursor cursor = db.rawQuery(sql, null);

        Pessoa pessoa = new Pessoa();

        if( cursor.moveToFirst() ){

            pessoa.setId(cursor.getLong(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setTelefone(cursor.getString(2));
            pessoa.setEmail(cursor.getString(3));
        }

        db.close();
        return pessoa;
    }

    public void adicionar(Pessoa pessoa, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("tbpessoa", null, values);

        db.close();
    }

    public void editar(Pessoa pessoa, ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();

        String[] arg = new String[1];
        arg[0] = pessoa.getId().toString();
        db.update("tbpessoa", values, "id = ?", arg);

        db.close();
    }

    public void salvar(Pessoa pessoa){

        ContentValues values = new ContentValues();
        values.put("nome", pessoa.getNome());
        values.put("email", pessoa.getEmail());
        values.put("telefone", pessoa.getTelefone());

        if(pessoa.getId() == null){
            adicionar(pessoa, values);
        } else {
            editar(pessoa, values);
        }
    }

    public void excluir(Pessoa pessoa){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tbpessoa", "id = ?", new String[]{pessoa.getId().toString()});
        db.close();
    }
}
