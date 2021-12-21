package org.zap.scala

/**
  *   - <Any> is the supertype of all types, also called the top type.
  *       * <Any> has two direct subclasses: <AnyVal> and <AnyRef>
  *
  *   - <AnyValue>
  *       * AnyVal represents value types. There are nine predefined value types and they are non-nullable:
  *       Double, Float, Long, Int, Short, Byte, Char, Unit, and Boolean
  *
  *   - <AnyRef>
  *       * AnyRef represents reference types. All non-value types are defined as reference types. Every
  *       user-defined type in Scala is a subtype of AnyRef
  *
  *   - <Nothing>
  *       * <Nothing> is a subtype of all types, also called the bottom type
  *       * There is no value that has type <Nothing>
  *
  *   - <Null>
  *       * <Null> is a subtype of all reference types (i.e. any subtype of AnyRef)
  *       * It has a single value identified by the keyword literal null
  */
class UnifiedTypes {

}
