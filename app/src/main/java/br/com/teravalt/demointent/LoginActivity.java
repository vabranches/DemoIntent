package br.com.teravalt.demointent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.etUsername) EditText etUsername;
    @BindView(R.id.etSenha) EditText etSenha;
    public static final int REQUEST_NOVO_USUARIO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.tvNovoUsuario)
    public void novoUsuarioClick(){
        Intent intent = new Intent(this, NovoUsuarioActivity.class);
        startActivityForResult(intent, REQUEST_NOVO_USUARIO);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_NOVO_USUARIO:
                etUsername.setText(data.getStringExtra("USERNAME"));
        }
    }
}
