package org.pentaho.hdfs.vfs;

import org.apache.commons.vfs.FileName;
import org.apache.commons.vfs.FileSystem;
import org.apache.commons.vfs.FileSystemException;
import org.apache.commons.vfs.FileSystemOptions;

/**
 * Provides access to the MapR FileSystem VFS implementation.
 *
 * @author Jordan Ganoff (jganoff@pentaho.com)
 */
public class MapRFileProvider extends HDFSFileProvider {
  /**
   * The scheme this provider was designed to support
   */
  public static final String SCHEME = "maprfs";
  /**
   * File System implementation for maprfs
   */
  public static final String FS_MAPR_IMPL = "com.mapr.fs.MapRFileSystem";

  public MapRFileProvider() {
    setFileNameParser(new MapRFileNameParser());
  }

  @Override
  protected FileSystem doCreateFileSystem(FileName name, FileSystemOptions fileSystemOptions) throws FileSystemException {
    return new MapRFileSystem(name, fileSystemOptions);
  }
}
