/*
 * Copyright 2014 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blogspot.codigogoogle.tempoagora;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TempoCidadeFragment extends Fragment {

    private TextView nomeCidadeTextView;

    public static TempoCidadeFragment newInstance(String nomeCidade) {
        TempoCidadeFragment fragment = new TempoCidadeFragment();

        Bundle args = new Bundle();
        args.putString("nomeCidade", nomeCidade);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tempo_cidade, container, false);
        nomeCidadeTextView = (TextView) rootView.findViewById(R.id.nomeCidadeTextView);
        nomeCidadeTextView.setText(getArguments().getString("nomeCidade"));

        return rootView;
    }
}