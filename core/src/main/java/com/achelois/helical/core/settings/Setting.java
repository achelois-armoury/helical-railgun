package com.achelois.helical.core.settings;

public class Setting {
    private boolean enable;
    private String endpoint, username, password;
    private int runid;
    private ResultTemplate result_template;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRunid() {
        return runid;
    }

    public void setRunid(int runid) {
        this.runid = runid;
    }

    public ResultTemplate getResult_template() {
        return result_template;
    }

    public void setResult_template(ResultTemplate result_template) {
        this.result_template = result_template;
    }

    @Override
    public String toString() {
        return "Setting{" +
                "enable=" + enable +
                ", endpoint='" + endpoint + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", runid=" + runid +
                ", result_template=" + result_template +
                '}';
    }
}
