package hari_krishna.io_streams;

import java.io.FilePermission;
import java.security.AccessControlException;
import java.security.Permission;
import java.security.PermissionCollection;

public class FilePermissionExample {

	public static void main(String[] args) {

		try {
            // Create a FilePermission object for the file with read and write permissions
            Permission perm = new FilePermission("files/test.txt", "read,write");
            
            // Get the permission collection for the file
            PermissionCollection permCollection = perm.newPermissionCollection();
            permCollection.add(perm);
            
            // Check if the current security manager allows the requested permissions
            SecurityManager sm = System.getSecurityManager();
            if (sm != null) {
                sm.checkPermission(perm);
            }
            
            // Grant the requested permissions to the file
            java.security.AccessController.checkPermission(perm);
            
            // Do something with the file, such as reading or writing to it
            // ...
            
        } catch (AccessControlException e) {
            System.err.println("AccessControlException: " + e.getMessage());
        }
	}
}
