package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import java.util.Collections;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        String token = Security.generateToken();
        ctx.cookie("token", token);
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var actualToken = ctx.cookie("token");
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var expectedToken = UserRepository.find(id).get().getToken();
        if (actualToken.equals(expectedToken)) {
            var user = UserRepository.find(id).get();
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        }
    }
    // END
}
