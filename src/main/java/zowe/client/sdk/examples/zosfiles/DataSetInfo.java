/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.examples.zosfiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zowe.client.sdk.core.ZOSConnection;
import zowe.client.sdk.examples.ZosConnection;
import zowe.client.sdk.zosfiles.ZosDsn;
import zowe.client.sdk.zosfiles.response.Dataset;

/**
 * Class example to showcase ZosDsn getDataSetInfo functionality.
 *
 * @author Frank Giordano
 * @version 1.0
 */
public class DataSetInfo extends ZosConnection {

    private static final Logger LOG = LoggerFactory.getLogger(DataSetInfo.class);

    /**
     * Main method defines z/OSMF host and user connection and other parameters needed to showcase
     * ZosDsn getDataSetInfo functionality.
     *
     * @param args for main not used
     * @throws Exception error processing request
     * @author Frank Giordano
     */
    public static void main(String[] args) throws Exception {
        String dataSetName = "XXX";
        ZOSConnection connection = new zowe.client.sdk.core.ZOSConnection(hostName, zosmfPort, userName, password);
        LOG.info(String.valueOf(DataSetInfo.getDataSetInfo(connection, dataSetName)));
    }

    private static Dataset getDataSetInfo(zowe.client.sdk.core.ZOSConnection connection, String dataSetName) throws Exception {
        ZosDsn zosDsn = new ZosDsn(connection);
        return zosDsn.getDataSetInfo(dataSetName);
    }

}
