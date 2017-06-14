/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 5025019
 * @summary REGRESSION: Sun implementation for HttpURLConnection could throw NPE
 * @modules java.base/sun.net
 *          java.base/sun.net.www.http
 */
import java.net.ServerSocket;
import java.net.URL;
import sun.net.www.http.HttpClient;

public class GetProxyPort {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(0);
        URL myURL = new URL("http://localhost:" + ss.getLocalPort());
        HttpClient httpC = new HttpClient(myURL, null, -1);
        int port = httpC.getProxyPortUsed();
    }
}