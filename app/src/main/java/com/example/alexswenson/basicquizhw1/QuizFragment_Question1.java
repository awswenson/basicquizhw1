package com.example.alexswenson.basicquizhw1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment_Question1 extends Fragment {

    private static final String ARG_CORRECT = "correct";
    private static final String ARG_TOTAL = "total";

    private int correct; // The number of questions answered correctly so far
    private int total; // The total number of questions encountered so far

    private TextView headerTextView;
    private ImageView imageImageView;
    private TextView questionTextView;
    private EditText answerEditText;
    private Button submitButton;

    public QuizFragment_Question1() {
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
    public static QuizFragment_Question1 newInstance(int correct, int total) {
        QuizFragment_Question1 fragment = new QuizFragment_Question1();
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
            total = getArguments().getInt(ARG_TOTAL) + 1;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz_question1, container, false);

        headerTextView = (TextView) view.findViewById(R.id.header);
        imageImageView = (ImageView) view.findViewById(R.id.image);
        questionTextView = (TextView) view.findViewById(R.id.question);
        answerEditText = (EditText) view.findViewById(R.id.answer);
        submitButton = (Button) view.findViewById(R.id.submit);

        // Set header text
        headerTextView.setText("Question " + total);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.containerQuizFragment, QuizFragment_Question2.newInstance(correct, total))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}
