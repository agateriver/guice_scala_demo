package com.agateriver

import com.google.inject._
import name._
import com.tzavellas.sse.guice.ScalaModule

class GuiceModule extends ScalaModule {
  def configure() {
    bind[Monster].to[HugeApe]
    bind[Food].to[Apple]
    bindConstant().annotatedWithName("Addr").to("Zool")
  }
}

trait Name{
  var name: String
}

abstract class Food extends  Name{
}

class Apple extends Food {
  var name = "Apple"
  println(name+  " is delicious!")
}

abstract class Monster extends  Name{
   val food: Food
}

class HugeApe extends Monster {
  var name = "Huge Ape"

  /*
  field inject
   */
  @Inject
  val food:Food = null
}

/*
constructor inject
 */
class MonsterShow @Inject() ( monster: Monster) {

  /*
  inject constant by annotated With Named
   */
  @Inject  @Named("Addr")
  var address: String = _

  def eat (){
      println( monster.name + " eating " +monster.food.name +" in " + address + ".")
  }
}

object GuiceDemo {
  def main(args: Array[String]): Unit = {
    val guiceModules = List( new GuiceModule())
    val injector = Guice.createInjector(guiceModules:_*)
    val monstershow = injector.getInstance(classOf[MonsterShow])
    monstershow.eat()
  }
}
