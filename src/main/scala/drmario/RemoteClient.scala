package drmario

@ remote trait RemoteClient {
  def drawStuff(myGrid: PassableGrid, theirGrid: PassableGrid, nextPiece: PillPiece)
}