package org.deepdive.apiserver.security.utils;

import java.util.List;

public final class NoAuthPath {
    public static List<String> paths = List.of(
            "/api/auth/login",
            "/api/auth/signup"
    );
}
