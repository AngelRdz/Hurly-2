package com.example.angel.viewpager2;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

/**
 * Created by Angel on 09/03/2015.
 */
public class Item extends Celda{

    private Post post = new Post();
    private PostComment comment = new PostComment();
    private int imagesrc;

    public Item(String title, String author, String creationDate, Long points, Long quanComments, String commentAuthor,
                String commentCreationDate, String content, int imagesrc, int x, int y, String vote) {
        this.post.setTitle(title);
        this.post.setAuthor(author);
        this.post.setCreationDate(creationDate);
        this.post.setPoints(points);
        this.post.setQuanComments(quanComments);

        if (x == 0) {
            post.setImageUrl("http://i.imgur.com/X46836q.gif");

            //"http://cdn.list25.com/wp-content/uploads/2011/11/penguifall.gif"
            post.setImageWidth(500);
            post.setImageHeight(500);
        }
        else if (x == 1) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/axZ9gQb_460s.jpg");
            post.setImageWidth(460);
            post.setImageHeight(888);
        }
        else if (x == 2) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/axZ9eLM_460s.jpg");
            post.setImageWidth(460);
            post.setImageHeight(878);
        }
        else if (x == 3) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/aB3myD1_460s.jpg");
            post.setImageWidth(460);
            post.setImageHeight(260);
        }
        else if (x == 4) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/a8YG9YQ_460s_v2.jpg");
            post.setImageWidth(460);
            post.setImageHeight(302);
        }
        else if (x == 5) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/avgzNVZ_460s_v1.jpg");
            post.setImageWidth(460);
            post.setImageHeight(711);
        }
        else if (x == 6) {
            post.setImageUrl("http://img-9gag-ftw.9cache.com/photo/aj09v6g_460s_v1.jpg");
            post.setImageWidth(460);
            post.setImageHeight(575);
        }

        if (y == 1)
        {
            comment.setImageUrl("http://cdn.techgyd.com/funny-profile-face-optical-illusion.jpg");
            comment.setImageWidth(336);
            comment.setImageHeight(361);
        }
        else if (y == 2)
        {
            comment.setImageUrl("http://www.google.com/+/images/learnmore/hero/hero-profile.jpg");
            comment.setImageWidth(978);
            comment.setImageHeight(517);
        }
        //http://www.google.com/+/images/learnmore/hero/hero-profile.jpg
        //http://cdn.techgyd.com/funny-profile-face-optical-illusion.jpg

        this.comment.setAuthor(commentAuthor);
        this.comment.setCreationDate(commentCreationDate);
        this.comment.setContent(content);
        this.post.setVote(vote);
        this.imagesrc = imagesrc;
    }

    @Override
    public int layoutId() {
        return R.layout.item;
    }

    @Override
    public void adaptView(View view) {
        TextView titleTextView = (TextView) view.findViewById(R.id.title);
        TextView authorTextView = (TextView) view.findViewById(R.id.post_author);
        TextView creationDateTextView = (TextView) view.findViewById(R.id.post_creationDate);
        final TextView pointsTextView = (TextView) view.findViewById(R.id.post_points);
        TextView quanCommentsTextView = (TextView) view.findViewById(R.id.post_comments);
        AspectRatioImageView imageView = (AspectRatioImageView) view.findViewById(R.id.post_image);
        TextView commentAuthorTextView = (TextView) view.findViewById(R.id.comment_author);
        TextView commentDateTextView = (TextView) view.findViewById(R.id.comment_creationDate);
        TextView commentContentTextView = (TextView) view.findViewById(R.id.comment_content);
        AspectRatioImageView commentImageView = (AspectRatioImageView) view.findViewById(R.id.comment_user);
        final ImageView upvoteImageView = (ImageView) view.findViewById(R.id.post_upvote);
        final ImageView downvoteImageView = (ImageView) view.findViewById(R.id.post_downvote);

        //ImageView commentImageView = (ImageView) view.findViewById(R.id.comment_user);

        titleTextView.setText(post.getTitle());
        authorTextView.setText(post.getAuthor());
        creationDateTextView.setText(post.getCreationDate());
        pointsTextView.setText(post.getPoints() +  " points");
        quanCommentsTextView.setText("·  " + post.getQuanComments() + " comments");

        imageView.setAspectRatio(1f * post.getImageWidth() / post.getImageHeight());
        commentImageView.setAspectRatio(1f * comment.getImageWidth() / comment.getImageHeight());
        //Picasso.with(view.getContext()).load(post.getImageUrl()).into(imageView);

        Ion.with(imageView).load(post.getImageUrl());
        Ion.with(commentImageView).load(comment.getImageUrl());

        commentAuthorTextView.setText(comment.getAuthor());
        commentDateTextView.setText(comment.getCreationDate());
        commentContentTextView.setText(comment.getContent());

        if (post.getVote().equals("upvote")) {
            upvoteImageView.setImageResource(R.drawable.arrowupb);
            downvoteImageView.setImageResource(R.drawable.arrowdownb);
        }
        else if (post.getVote().equals("downvote")) {
            downvoteImageView.setImageResource(R.drawable.arrowdown_2b);
            upvoteImageView.setImageResource(R.drawable.arrowup_2b);
        }

        upvoteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (post.getVote().equals("upvote") && post.getVote() != "null") {
                    upvoteImageView.setImageResource(R.drawable.arrowup_2b);
                    post.setVote("null");
                    post.setPoints(post.getPoints() - 1);
                    pointsTextView.setText(post.getPoints() +  " points");
                }
                else if (post.getVote().equals("downvote") && post.getVote() != "null"){
                    upvoteImageView.setImageResource(R.drawable.arrowupb);
                    downvoteImageView.setImageResource(R.drawable.arrowdownb);
                    post.setVote("upvote");
                    post.setPoints(post.getPoints() + 2);
                    pointsTextView.setText(post.getPoints() +  " points");
                }
                else {
                    upvoteImageView.setImageResource(R.drawable.arrowupb);
                    downvoteImageView.setImageResource(R.drawable.arrowdownb);
                    post.setVote("upvote");
                    post.setPoints(post.getPoints() + 1);
                    pointsTextView.setText(post.getPoints() + " points");
                }
            }
        });

        downvoteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (post.getVote().equals("downvote") && post.getVote() != "null") {
                    downvoteImageView.setImageResource(R.drawable.arrowdownb);
                    post.setVote("null");
                    post.setPoints(post.getPoints() + 1);
                    pointsTextView.setText(post.getPoints() +  " points");
                }
                else if (post.getVote().equals("upvote") && post.getVote() != "null"){
                    downvoteImageView.setImageResource(R.drawable.arrowdown_2b);
                    upvoteImageView.setImageResource(R.drawable.arrowup_2b);
                    post.setVote("downvote");
                    post.setPoints(post.getPoints() - 2);
                    pointsTextView.setText(post.getPoints() +  " points");
                }
                else {
                    downvoteImageView.setImageResource(R.drawable.arrowdown_2b);
                    upvoteImageView.setImageResource(R.drawable.arrowup_2b);
                    post.setVote("downvote");
                    post.setPoints(post.getPoints() - 1);
                    pointsTextView.setText(post.getPoints() + " points");
                }
            }
        });

        //commentImageView.setImageResource(R.drawable.box);
    }


}
