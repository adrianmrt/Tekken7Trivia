package com.example.tekken7trivia.game;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.tekken7trivia.R;
import com.example.tekken7trivia.database.DatabaseViewModel;
import com.example.tekken7trivia.database.Question;

public class QuestionFragment extends Fragment {

    View rootView;
    int _questionAct;
    DatabaseViewModel questionDatabase;
    Question _question;
    //Layout elements
    ImageView imageView;
    TextView questionText;
    VideoView videoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle passData = getArguments();
        _questionAct = passData.getInt("actualQuestion");
        questionDatabase = new ViewModelProvider(this).get(DatabaseViewModel.class);
        _question = questionDatabase.GetQuestion(_questionAct);

        if (_question.get_questionType() == 0) {
            rootView = inflater.inflate(R.layout.question_text_layout, container, false);
            questionText = rootView.findViewById(R.id.textQuestionText);
            questionText.setText(_question.get_question());
        } else if (_question.get_questionType() == 1) {
            rootView = inflater.inflate(R.layout.question_img_layout, container, false);
            questionText = rootView.findViewById(R.id.textQuestionImg);
            questionText.setText(_question.get_question());
            imageView = rootView.findViewById(R.id.imgQuestion);
            imageView.setImageResource(Integer.parseInt(_question.get_images().get(0)));
        } else if (_question.get_questionType() == 2) {
            rootView = inflater.inflate(R.layout.question_video_layout, container, false);
            questionText = rootView.findViewById(R.id.videoQuestionText);
            String question= _question.get_question();
            questionText.setText(question);
            videoView = rootView.findViewById(R.id.videoView);
            String mediaPath=_question.get_multimediaFileId();
            videoView.setVideoPath(mediaPath);
            MediaController mediaController= new MediaController(getContext());
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });




        }
        return rootView;
    }
}