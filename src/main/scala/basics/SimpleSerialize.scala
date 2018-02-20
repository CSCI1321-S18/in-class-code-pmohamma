package basics

import java.io.FileOutputStream
import java.io.ObjectOutputStream
import java.io.FileInputStream
import java.io.ObjectInputStream

class ALittleClass(val x:Double, val i:Int, val str:String) extends Serializable

object SimpleSerialize extends App {
  val alc = new ALittleClass(0.5, 42, "This is a test.")
  val oos = new ObjectOutputStream(new FileOutputStream("alc.bin"))
  oos.writeObject(alc)
  oos.close()
  val ois = new ObjectInputStream(new FileInputStream("alc.bin"))
  ois.read() //check on this part
}