import scala.meta.internal.ast.{Name => _, _}, Import._, Selector._, Term.{This, Name => TermName, Select, Super}
import scala.meta.internal.ast.Name.Imported
import scala.meta.dialects.Scala211

class ImportSuite extends ParseSuite {
  test("import foo.bar") {
    val Import(Clause(TermName("foo"), Name(Imported("bar")) :: Nil) :: Nil) = templStat("import foo.bar")
  }

  test("import foo.bar.baz") {
    val Import(Clause(Select(TermName("foo"), TermName("bar")), Name(Imported("baz")) :: Nil) :: Nil) =
      templStat("import foo.bar.baz")
  }

  test("import super.foo.bar") {
    val Import(Clause(Select(Super(None, None), TermName("foo")), Name(Imported("bar")) :: Nil) :: Nil) =
      templStat("import super.foo.bar")
  }

  test("import this.foo.bar") {
    val Import(Clause(Select(This(None), TermName("foo")), Name(Imported("bar")) :: Nil) :: Nil) =
      templStat("import this.foo.bar")
  }

  test("import foo.bar._") {
    val Import(Clause(Select(TermName("foo"), TermName("bar")), Wildcard() :: Nil) :: Nil) =
      templStat("import foo.bar._")
  }

  test("import super.foo._") {
    val Import(Clause(Select(Super(None, None), TermName("foo")), Wildcard() :: Nil) :: Nil) =
      templStat("import super.foo._")
  }

  test("import this.foo._") {
    val Import(Clause(Select(This(None), TermName("foo")), Wildcard() :: Nil) :: Nil) =
      templStat("import this.foo._")
  }

  test("import foo.{bar}") {
    val Import(Clause(TermName("foo"), Name(Imported("bar")) :: Nil) :: Nil) = templStat("import foo.{bar}")
  }

  test("import foo.{bar, baz}") {
    val Import(Clause(TermName("foo"), Name(Imported("bar")) :: (Name(Imported("baz"))) :: Nil) :: Nil) =
      templStat("import foo.{bar, baz}")
  }

  test("import foo.{bar => baz}") {
    val Import(Clause(TermName("foo"), Rename(Imported("bar"), Imported("baz")) :: Nil) :: Nil) =
      templStat("import foo.{bar => baz}")
  }

  test("import foo.{bar => _}") {
    val Import(Clause(TermName("foo"), Unimport(Imported("bar")) :: Nil) :: Nil) =
      templStat("import foo.{bar => _}")
  }

  test("import foo.{bar => _, _}") {
    val Import(Clause(TermName("foo"), Unimport(Imported("bar")) :: Wildcard() :: Nil) :: Nil) =
      templStat("import foo.{bar => _, _}")
  }

  test("import foo.{bar, baz => _, _}") {
    val Import(Clause(TermName("foo"), (Name(Imported("bar"))) :: Unimport(Imported("baz")) :: Wildcard() :: Nil) :: Nil) =
      templStat("import foo.{bar, baz => _, _}")
  }
}
