package com.blogspot.codigogoogle.tempoagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class TempoAgoraMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tempo_agora_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tempo_agora_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private EditText cidadeEditText;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tempo_agora_main, container, false);
            cidadeEditText = (EditText) rootView.findViewById(R.id.cidadeEditText);

            Button pesquisarButton = (Button) rootView.findViewById(R.id.pesquisarButton);
            pesquisarButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (cidadeEditText != null && cidadeEditText.getText() != null
                            && cidadeEditText.getText().toString().length() > 0) {
                        pesquisarTempoCidade();
                    } else {
                        Toast.makeText(getActivity(), "Cidade não preenchida", Toast.LENGTH_SHORT).
                                show();
                    }
                }
            });
            return rootView;
        }

        private void pesquisarTempoCidade() {
            //Método que irá efetuar a busca
            Intent i = new Intent(getActivity(), TempoCidadeActivity.class);
            i.putExtra("nomeCidade", cidadeEditText.getText().toString());
            startActivity(i);
        }
    }
}
