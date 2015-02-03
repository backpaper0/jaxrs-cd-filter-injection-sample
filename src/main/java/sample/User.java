package sample;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

/**
 * ユーザーの情報を保持するオブジェクト。
 *
 */
@SessionScoped
public class User implements Serializable {

    /**
     * ユーザー名
     */
    private String username;

    /**
     * ログインしているかどうか
     */
    private boolean loggedin;

    public String getUsername() {
        return username;
    }

    public boolean isLoggedin() {
        return loggedin;
    }

    /**
     * ログインする
     * 
     * @param username ユーザー名
     */
    public void login(String username) {
        this.username = username;
        this.loggedin = true;
    }
}
