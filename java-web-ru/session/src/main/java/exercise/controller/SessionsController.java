package exercise.controller;

import java.util.Collections;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.Generator;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import lombok.extern.java.Log;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("name");
        var password = ctx.formParam("password");
        for (var user : Generator.getUsers()) {
            if (nickname.equals(user.getName()) && encrypt(password).equals(user.getPassword())) {
                ctx.sessionAttribute("currentUser", nickname);
                ctx.redirect(NamedRoutes.rootPath());
            }
        }
        var page = new LoginPage(null, "Wrong username or password");
        ctx.render("build.jte", Collections.singletonMap("error", page.getError()));
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
