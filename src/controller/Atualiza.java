package controller;

import Model.Post;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(urlPatterns = {"/atualiza"})
public class Atualiza extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post p = new Post();
        String param = request.getParameter("search") == null ? "" : request.getParameter("search");
        ArrayList<Post> ps = p.getPosts(param);

        Gson gson = new Gson();
        JsonElement element = gson.toJsonTree(ps, new TypeToken<List<Post>>() {
        }.getType());
        JsonArray jsonArray = element.getAsJsonArray();

        response.setContentType("application/json");
        response.getWriter().write(jsonArray.toString());
    }
}