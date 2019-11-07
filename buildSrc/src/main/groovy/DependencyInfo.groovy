class DependencyInfo {

    String path
    String localPath
    String remotePath
    boolean useLocal
    def dep

    DependencyInfo(String path) {
        this.path = path

        if (path.startsWith(":")) {
            localPath = path
            useLocal = true
        } else {
            remotePath = path
            useLocal = false
        }
    }

    DependencyInfo(String localPath, String remotePath, boolean useLocal) {
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