package com.keanntech.framework.admin.dto;

import java.util.List;

public class SysMenuParams {

    private String  path;
    private String  name;
    private Integer type;
    private String  component;
    private Meta    meta;
    private List<SysMenuParams> children;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<SysMenuParams> getChildren() {
        return children;
    }

    public void setChildren(List<SysMenuParams> children) {
        this.children = children;
    }

    public class Meta {
        private String title;
        private String icon;
        private boolean noCache;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public boolean isNoCache() {
            return noCache;
        }

        public void setNoCache(boolean noCache) {
            this.noCache = noCache;
        }
    }
}
