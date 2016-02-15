package com.example.alexswenson.basicquizhw1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment_Results extends Fragment {

    private static final String ARG_CORRECT = "correct";
    private static final String ARG_TOTAL = "total";

    private int correct; // The number of questions answered correctly so far
    private int total; // The total number of questions encountered so far

    private TextView headerTextView;
    private TextView resultsTextView;
    private Button retryButton;
    private Button quitButton;

    public QuizFragment_Results() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param correct The number of questions answered correctly so far.
     * @param total The total number of questions encountered so far.
     * @return A new instance of fragment QuizFragment_Question1.
     */
    public static QuizFragment_Results newInstance(int correct, int total) {
        QuizFragment_Results fragment = new QuizFragment_Results();
        Bundle args = new Bundle();
        args.putInt(ARG_CORRECT, correct);
        args.putInt(ARG_TOTAL, total);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            correct = getArguments().getInt(ARG_CORRECT);
            total = getArguments().getInt(ARG_TOTAL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_results, container, false);

        headerTextView = (TextView) view.findViewById(R.id.header);
        resultsTextView = (TextView) view.findViewById(R.id.results);
        retryButton = (Button) view.findViewById(R.id.retry);
        quitButton = (Button) view.findViewById(R.id.quit);

        // Set header text
        headerTextView.setText("Results");

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retryButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerQuizFragment, QuizFragment_Question1.newInstance(0, 0))
                        .addToBackStack(null)
                        .commit();
            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

    }

}
