package drmario

@remote trait RemoteServer {
  def connect(client:RemoteClient): RemoteGrid
}