package br.unicamp.ft.s187064_m184082.buckboard.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.unicamp.ft.s187064_m184082.buckboard.controller.Autenticador;
import br.unicamp.ft.s187064_m184082.buckboard.controller.Compartilhador;
import br.unicamp.ft.s187064_m184082.buckboard.model.Postagem;
import br.unicamp.ft.s187064_m184082.buckboard.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SharePostFragment extends Fragment {

    public interface OnPostShareEnded {
        void onPostShared();
    }

    private Postagem post;

    private View view;

    private OnPostShareEnded listenerShareEnded;

    public SharePostFragment() {
        // Required empty public constructor
    }

    public void setListenerShareEnded(OnPostShareEnded listenerShareEnded) {
        this.listenerShareEnded = listenerShareEnded;
    }

    public void setPost(Postagem post) {
        this.post = post;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_share_post, container, false);

        view.findViewById(R.id.botao_compartilhar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Postagem postagemCompartilhada = new Postagem("", null, Autenticador.getIdUsuarioLogado(), "share", post.getId());

                Compartilhador.compartilhar(postagemCompartilhada);

                if(listenerShareEnded != null) {
                    listenerShareEnded.onPostShared();
                }
            }
        });

        bind();

        return view;
    }

    private void bind() {
        ImageView imageView = new ImageView(view.getContext());
        //imageView.setImageResource(post.getFoto());

        TextView textView = new TextView(view.getContext());
        textView.setText(post.getConteudo());

        ((LinearLayout) view.findViewById(R.id.post)).addView(textView);
        ((LinearLayout) view.findViewById(R.id.post)).addView(imageView);
    }

}
