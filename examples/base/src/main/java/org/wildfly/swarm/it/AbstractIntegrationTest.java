/*
 * #%L
 * Wildfly Swarm :: Examples :: Base
 * %%
 * Copyright (C) 2016 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.wildfly.swarm.it;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Bob McWhirter
 */
public class AbstractIntegrationTest {

    protected Log getStdOutLog() throws Exception {
        return getLog( "target/stdout.log" );
    }

    protected Log getStdErrLog() throws Exception {
        return getLog( "target/stderr.log" );
    }

    protected Log getLog(String path) throws IOException {

        FileInputStream in = new FileInputStream( new File( path ) );

        BufferedReader reader = new BufferedReader( new InputStreamReader( in ) );

        String line = null;

        List<String> lines = new ArrayList<>();

        while ( ( line = reader.readLine() ) != null ) {
            lines.add( line );
        }

        return new Log(lines);
    }

    public LogAssert assertThatLog(Log log) {
        return new LogAssert( log );
    }
}
