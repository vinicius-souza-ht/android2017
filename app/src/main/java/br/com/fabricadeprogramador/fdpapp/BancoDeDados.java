package br.com.fabricadeprogramador.fdpapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
        return null;
    }

    public Pessoa buscarPorId(int id){
        return null;
    }

    public void adicionar(Pessoa pessoa){}

    public void editar(Pessoa pessoa){}

    public void salvar(Pessoa pessoa){}

    public void excluir(Pessoa pessoa){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("tbpessoa", "id = ?", new String[]{pessoa.getId().toString()});
        db.close();

    }
}
