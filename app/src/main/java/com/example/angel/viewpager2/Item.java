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
                String commentCreationDate, String content, int imagesrc, int x) {
        this.post.setTitle(title);
        this.post.setAuthor(author);
        this.post.setCreationDate(creationDate);
        this.post.setPoints(points);
        this.post.setQuanComments(quanComments);

        if (x == 0) {
            post.setImageUrl("http://cdn.list25.com/wp-content/uploads/2011/11/penguifall.gif");
            post.setImageWidth(320);
            post.setImageHeight(240);
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
        this.comment.setAuthor(commentAuthor);
        this.comment.setCreationDate(commentCreationDate);
        this.comment.setContent(content);
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
        TextView pointsTextView = (TextView) view.findViewById(R.id.post_points);
        TextView quanCommentsTextView = (TextView) view.findViewById(R.id.post_comments);
        AspectRatioImageView imageView = (AspectRatioImageView) view.findViewById(R.id.post_image);
        TextView commentAuthorTextView = (TextView) view.findViewById(R.id.comment_author);
        TextView commentDateTextView = (TextView) view.findViewById(R.id.comment_creationDate);
        TextView commentContentTextView = (TextView) view.findViewById(R.id.comment_content);
        ImageView commentImageView = (ImageView) view.findViewById(R.id.comment_user);

        titleTextView.setText(post.getTitle());
        authorTextView.setText(post.getAuthor());
        creationDateTextView.setText(post.getCreationDate());
        pointsTextView.setText(post.getPoints() +  " points");
        quanCommentsTextView.setText("·  " + post.getQuanComments() + " comments");

        imageView.setAspectRatio(1f * post.getImageWidth() / post.getImageHeight());
        //Picasso.with(view.getContext()).load(post.getImageUrl()).into(imageView);
        Ion.with(imageView).load(post.getImageUrl());

        commentAuthorTextView.setText(comment.getAuthor());
        commentDateTextView.setText(comment.getCreationDate());
        commentContentTextView.setText(comment.getContent());
        commentImageView.setImageResource(R.drawable.box);
    }
}
