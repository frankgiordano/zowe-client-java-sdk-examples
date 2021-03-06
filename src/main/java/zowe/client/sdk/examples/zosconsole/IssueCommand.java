/*
 * This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Copyright Contributors to the Zowe Project.
 */
package zowe.client.sdk.examples.zosconsole;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import zowe.client.sdk.core.ZOSConnection;
import zowe.client.sdk.examples.ZosConnection;
import zowe.client.sdk.zosconsole.ConsoleResponse;
import zowe.client.sdk.zosconsole.input.IssueParams;
import zowe.client.sdk.zosconsole.zosmf.ZosmfIssueParams;
import zowe.client.sdk.zosconsole.zosmf.ZosmfIssueResponse;

/**
 * Class example to showcase mvs console command functionality.
 *
 * @author Frank Giordano
 * @version 1.0
 */
public class IssueCommand extends ZosConnection {

    private static final Logger LOG = LoggerFactory.getLogger(IssueCommand.class);

    /**
     * Main method defines z/OSMF host and user connection, and mvs command used for the example test.
     *
     * @param args for main not used
     * @author Frank Giordano
     */
    public static void main(String[] args) {
        String command = "D IPLINFO";
        ZOSConnection connection = new zowe.client.sdk.core.ZOSConnection(hostName, zosmfPort, userName, password);
        IssueCommand.consoleCmdByIssue(connection, command);
        IssueCommand.consoleCmdByIssueSimple(connection, command);
        IssueCommand.consoleCmdByIssueDefConsoleCommon(connection, command);
    }

    /**
     * Issue IssueCommend issue method which will execute the given mvs console command
     *
     * @param connection connection information, see ZOSConnection object
     * @param cmd        mvs command to execute
     * @author Frank Giordano
     */
    public static void consoleCmdByIssue(zowe.client.sdk.core.ZOSConnection connection, String cmd) {
        IssueParams params = new IssueParams();
        params.setCommand(cmd);
        ConsoleResponse response;
        zowe.client.sdk.zosconsole.IssueCommand issueCommand = new zowe.client.sdk.zosconsole.IssueCommand(connection);
        try {
            response = issueCommand.issue(params);
            LOG.info(response.getCommandResponse().orElse(""));
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

    /**
     * Issue IssueCommend issueSimple method which will execute the given mvs console command
     *
     * @param connection connection information, see ZOSConnection object
     * @param cmd        mvs command to execute
     * @author Frank Giordano
     */
    public static void consoleCmdByIssueSimple(zowe.client.sdk.core.ZOSConnection connection, String cmd) {
        ConsoleResponse response;
        zowe.client.sdk.zosconsole.IssueCommand issueCommand = new zowe.client.sdk.zosconsole.IssueCommand(connection);
        try {
            response = issueCommand.issueSimple(cmd);
            LOG.info(response.getCommandResponse().orElse(""));
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

    /**
     * Issue IssueCommend issueDefConsoleCommon method which will execute the given mvs console command
     *
     * @param connection connection information, see ZOSConnection object
     * @param cmd        mvs command to execute
     * @author Frank Giordano
     */
    public static void consoleCmdByIssueDefConsoleCommon(zowe.client.sdk.core.ZOSConnection connection, String cmd) {
        ZosmfIssueParams params = new ZosmfIssueParams();
        params.setCmd(cmd);
        ZosmfIssueResponse zResponse;
        zowe.client.sdk.zosconsole.IssueCommand issueCommand = new zowe.client.sdk.zosconsole.IssueCommand(connection);
        try {
            zResponse = issueCommand.issueDefConsoleCommon(params);
            LOG.info(zResponse.getCmdResponse().orElse(""));
        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

}
