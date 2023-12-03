package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found."));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }

    public static void index(Context ctx) {
        var posts = PostRepository.getEntities();
        var numOfPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var begin = numOfPage*5-5;
        var end = numOfPage*5;
        var subPosts = posts.subList(begin, end);
        var page = new PostsPage(subPosts);
        ctx.render("posts/index.jte", Map.of("page", page, "numOfPage", numOfPage));
    }
    // END
}
