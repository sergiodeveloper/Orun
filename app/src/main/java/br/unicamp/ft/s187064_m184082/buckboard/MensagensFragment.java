package br.unicamp.ft.s187064_m184082.buckboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MensagensFragment extends Fragment {

    private View view;

    public MensagensFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view == null){
            view = inflater.inflate(R.layout.fragment_mensagens, container, false);
        }

        final List<PreviewMensagem> mensagensList = new LinkedList<>();
        mensagensList.add(new PreviewMensagem("Mateus", "A entrega é até segunda", R.drawable.mateus_tanaka));
        mensagensList.add(new PreviewMensagem( "Sérgio", "Blz, estou fazendo o vídeo", R.drawable.sergio_filho));
        mensagensList.add(new PreviewMensagem( "Laís", "Pra quando é o trabalho de android", R.drawable.lais_arcaro));
        mensagensList.add(new PreviewMensagem( "Amadeu", "Semana que vem eu vou", R.drawable.amadeu_carvalho));
        mensagensList.add(new PreviewMensagem( "Guilherme", "Falow valeu", R.drawable.gilherme_santos));
        mensagensList.add(new PreviewMensagem( "Alex", "Que sala é a palestra?", R.drawable.alex_rafael));
        mensagensList.add(new PreviewMensagem( "Felipe", "Precisa colocar ListView", R.drawable.felipe_tosta));
        mensagensList.add(new PreviewMensagem( "Kelvin", "Amanhã tem a palestra na PA07", R.drawable.kelwin_falico));

        ArrayAdapter<PreviewMensagem> adapter = new ArrayAdapter<PreviewMensagem>(view.getContext(), R.layout.layout_list_view_mensagem, R.id.nome_contato, mensagensList){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);

                PreviewMensagem entry = mensagensList.get(position);
                TextView textViewNome = view.findViewById(R.id.nome_contato);
                TextView textViewMensagem = view.findViewById(R.id.ultima_mensagem);
                ImageView imageView = view.findViewById(R.id.foto);
                textViewNome.setText(entry.getNome());
                textViewMensagem.setText(entry.getMensagem());
                imageView.setImageResource(entry.getFoto());

                return view;
            }
        };

        ListView listv = view.findViewById(R.id.lista_mensagens);
        listv.setAdapter(adapter);

        return view;
    }

}