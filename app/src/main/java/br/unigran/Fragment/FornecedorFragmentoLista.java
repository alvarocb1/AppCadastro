package br.unigran.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.unigran.BancoDados.DBHelper;
import br.unigran.BancoDados.FornecedorDB;
import br.unigran.Entidades.Fornecedor;
import br.unigran.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FornecedorFragmentoLista#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FornecedorFragmentoLista extends Fragment {
    DBHelper db;
    FornecedorDB fornecedorDB;
    List<Fornecedor> dados;
    ListView fornecedorLista;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FornecedorFragmentoLista() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FornecedorFragmentoLista.
     */
    // TODO: Rename and change types and number of parameters
    public static FornecedorFragmentoLista newInstance(String param1, String param2) {
        FornecedorFragmentoLista fragment = new FornecedorFragmentoLista();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fornecedor_lista, container, false);
        fornecedorLista = (ListView) view.findViewById(R.id.listaId);
        dados = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(
                getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, dados);
        fornecedorLista.setAdapter(arrayAdapter);
        db = new DBHelper(getActivity());
        fornecedorDB = new FornecedorDB(db);
        fornecedorDB.lista(dados);

        return view;
    }
}