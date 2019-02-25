package de.consol.labs.aws.neptunedemoapp.common.remote;

public class RemoteConnectionSettings {

    private String endpoint;
    private Integer port;
    private boolean isEnableSsl;
    private String keyCertChainFile;

    public String getEndpoint() {
        return endpoint;
    }

    public RemoteConnectionSettings setEndpoint(final String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public Integer getPort() {
        return port;
    }

    public RemoteConnectionSettings setPort(final Integer port) {
        this.port = port;
        return this;
    }

    public boolean isEnableSsl() {
        return isEnableSsl;
    }

    public RemoteConnectionSettings setEnableSsl(final boolean enableSsl) {
        isEnableSsl = enableSsl;
        return this;
    }

    public String getKeyCertChainFile() {
        return keyCertChainFile;
    }

    public RemoteConnectionSettings setKeyCertChainFile(final String keyCertChainFile) {
        this.keyCertChainFile = keyCertChainFile;
        return this;
    }
}
