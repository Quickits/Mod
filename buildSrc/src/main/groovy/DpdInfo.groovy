/**
 * Dependence Info
 *
 * @author Gavin Liu
 *
 * Created on 2019/11/7.
 */
class DpdInfo {

    String path
    String localPath
    String remotePath
    boolean useLocal
    def dep

    DpdInfo(String path) {
        this.path = path

        if (path.startsWith(":")) {
            localPath = path
            useLocal = true
        } else {
            remotePath = path
            useLocal = false
        }
    }

    DpdInfo(String localPath, String remotePath, boolean useLocal) {
        this.localPath = localPath
        this.remotePath = remotePath
        this.useLocal = useLocal
        this.path = useLocal ? localPath : remotePath
    }


    @Override
    String toString() {
        return "DependencyInfo { $path }"
    }

}