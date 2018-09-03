/*
 * Copyright (c) 2002-2018 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j Enterprise Edition. The included source
 * code can be redistributed and/or modified under the terms of the
 * GNU AFFERO GENERAL PUBLIC LICENSE Version 3
 * (http://www.fsf.org/licensing/licenses/agpl-3.0.html) with the
 * Commons Clause, as found in the associated LICENSE.txt file.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * Neo4j object code can be licensed independently from the source
 * under separate terms from the AGPL. Inquiries can be directed to:
 * licensing@neo4j.com
 *
 * More information is also available at:
 * https://neo4j.com/licensing/
 */
package org.neo4j.backup;

import java.util.Map;

import org.neo4j.kernel.configuration.Settings;
import org.neo4j.kernel.extension.KernelExtensionFactoryContractTest;

public class TestOnlineBackupExtension extends KernelExtensionFactoryContractTest
{
    public TestOnlineBackupExtension()
    {
        super( OnlineBackupExtensionFactory.KEY, OnlineBackupExtensionFactory.class );
    }

    @Override
    protected Map<String, String> configuration( boolean shouldLoad, int instance )
    {
        Map<String, String> configuration = super.configuration( shouldLoad, instance );
        if ( shouldLoad )
        {
            configuration.put( OnlineBackupSettings.online_backup_enabled.name(), Settings.TRUE );
            configuration.put( OnlineBackupSettings.online_backup_server.name(), ":" +
                    (BackupServer.DEFAULT_PORT + instance) );
        }
        return configuration;
    }
}