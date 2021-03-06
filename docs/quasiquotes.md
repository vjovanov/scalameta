## Literals

         | Quasiquote
---------|------------------------------
 Boolean | `q"true"`, `q"false"`, `q"$bool"`
 Int     | `q"1"`, `q"$int"`
 Long    | `q"1L"`, `q"$long"`
 Float   | `q"1.0"`, `q"$float"`
 Double  | `q"1.0d"`, `q"$double"`
 Char    | `q" 'c' "`, `q"$char"`
 String  | `q""" "s" """`, `q"$str"`
 Symbol  | `q" 's "`, `q"$symbol"`
 Null    | `q"null"`
 Unit    | `q"()"`

## Expressions (meta.Term)

                   | Quasiquote
-------------------|------------------
 This              | `q"$stropt.this"`
 Super             | `q"$stropt.super[$stropt]"`
 Name              | `q"name"`
 Selection         | `q"$expr.$name"`
 Interpolation     | `q""" $name"$${..$exprs}" """`
 Application       | `q"$expr(..$aexprs)"`
 Type Application  | `q"$expr[..$tpes]"`
 Infix Application | `q"$expr $name[..$tpes] (..$aexprs)"`
 Unary Application | `q"!$expr", q"~$expr", q"-$expr", "+$expr"`
 Assign            | `q"$ref = $expr"`
 Update            | `q"$expr(..$aexprs) = $expr"`
 Return            | `q"return $expropt"`
 Throw             | `q"throw $expr"`
 Ascribe           | `q"$expr: $tpe"`
 Annotate          | `q"$expr: ..@$expr"`
 Tuple             | `q"(..$exprs)"`
 Block             | `q"{ ..$stats }"`
 If                | `q"if ($expr) $expr else $expr"`
 Match             | `q"$expr match { ..case $cases }"`
 Try Catch Cases   | `q"try $expr catch { ..case $cases } finally $expropt"`
 Try Catch Expr    | `q"try $expr catch $expr finally $expropt" `
 Function          | `q"(..$params) => $expr"`
 Partial Function  | `q"{ ..case $cases }"`
 While             | `q"while ($expr) $expr"`
 Do While          | `q"do $expr while($expr)"`
 For               | `q"for (..$enumerators) $expr"`
 For Yield         | `q"for (..$enumerators) yield $expr"`
 New               | `q"new $template"`
 Placeholder       | `q"_"`
 Eta Expansion     | `q"$expr _"`
 Literal           | `q"$lit"`

## Arguments (meta.Term.Arg)

            | Quasiquote
------------|------------------------------
 Named      | `aexpr"$name = $expr"`
 Repeated   | `aexpr"$expr: _*"`
 Expression | `aexpr"$expr"`

## Types (meta.Type)

                   | Quasiquote
-------------------|------------------------------
 Name              | `t"name"`
 Selection         | `t"$ref.$tname"`
 Projection        | `t"$tpe#$tname"`
 Singleton         | `t"$ref.type"`
 Application       | `t"$tpe[..$tpes]`
 Infix Application | `t"$tpe $tname $tpe"`
 Function          | `t"(..$atpes) => $tpe"`
 Tuple             | `t"(..$tpes)"`
 Compound          | `t"..$tpes { ..$stats }"`
 Existential       | `t"$tpe forSome { ..$stats }"`
 Annotate          | `t"$tpe ..@$expr"`
 Placeholder       | `t"_ >: $tpeopt <: tpeopt"`
 Literal           | `t"$lit"`

## Argument Types (meta.Type.Arg)

          | Quasiquote
----------|-----------------
 By Name  | `t"=> $tpe"`
 Repeated | `t"$tpe *"`
 Type     | `t"$tpe"`

## Patterns (meta.Pat)

               | Quasiquote
---------------|----------------------------
 Wildcard      | `p"_"`
 Var           | `p"name"`
 Bind          | `p"$name @ $pat"`
 Alternative   | `p"$pat | $pat"`
 Tuple         | `p"(..$pats)"`
 Extract       | `p"$ref[..$tpes](..$apats)"`
 Infix Extract | `p"$pat $name (..$apats)"`
 Interpolation | `p""" $name"$${..$pats}" """`
 Typed         | `p"$pat: $tpe"`
 Name          | `p"`name`"`
 Selection     | `p"$expr.$name"`
 Literal       | `p"$lit"`

## Argument Patterns (meta.Pat.Arg)

                   | Quasiquote
-------------------|----------------------------
 Sequence Wildcard | `p"_*"`
 Pattern           | `p"$pat"`

## Statements (meta.Stat)

            | Quasiquote
------------|----------------------------
 Expression | `q"$expr"`
 Member     | `q"$member"`
 Import     | `q"import ..($ref.{..$importees})"`

## Members (meta.Member)

### Declarations

           | Quasiquote
-----------|------------------------------
 Val       | `q"..$mods val ..$names: $tpe"`
 Var       | `q"..$mods var ..$names: $tpe"`
 Def       | `q"..$mods def $name[..$tparams](...$paramss): $tpe"`
 Type      | `q"..$mods type $tname[..$tparams] >: $tpeopt <: tpeopt"`

### Definitions

                | Quasiquote
----------------|------------------------------
 Val            | `q"..$mods val ..$pats: $tpeopt = $expr"`
 Var            | `q"..$mods var ..$pats: $tpeopt = $expropt"`
 Def            | `q"..$mods def $name[..$tparams](...$paramss): $tpeopt = $expr"`
 Macro          | `q"..$mods def $name[..$tparams](...$paramss): $tpe = macro $expr"`
 Type           | `q"..$mods type $tname[..$tparams] = $tpe"`
 Class          | `q"..$mods class $tname[..$tparams] $member extends $template"`
 Trait          | `q"..$mods trait $tname[..$tparams] extends $template"`
 Object         | `q"..$mods object $name extends $template"`
 Package Object | `q"package object $name extends $template"`
 Package        | `q"package $ref { ..$stats }"`

### Params

                | Quasiquote
----------------|-------------------------------------------------
 Term Param     | `param"..$mods $nameopt: $atpeopt = $defaultopt"`
 Type Param     | `param"..$mods type $nameopt[..$tparams] <% ..$tpes : ..$tpes >: $tpeopt <: $tpeopt"`

## Constructors (meta.Member) and Constructor References (meta.Ctor.Ref and meta.Term)

                     | Quasiquote
---------------------|------------------------------
 Primary Ctor        | `ctor"..$mods def this(..$paramss)"`
 Secondary Ctor      | `ctor"..$mods def this(..$paramss) = { this(...$aexprss); ..$stats }"`
 Name Reference      | `ctor"$ctorname"`
 Select Reference    | `ctor"$ref.$ctorname"`
 Project Reference   | `ctor"$tpe#$ctorname"`
 Function Reference  | `ctor"(..$tpes) => $tpe"`
 Annotated Reference | `ctor"$ctorname ..@$expr"`
 Applied Reference   | `ctor"$ctorref(...$aexprss)"`
 Tapplied Reference  | `ctor"$ctorref[..$atpes]"`

                | Quasiquote
----------------|------------------------------
 Val            | `q"..$mods val ..$pats: $tpeopt = $expr"`
 Var            | `q"..$mods var ..$pats: $tpeopt = $expropt"`
 Def            | `q"..$mods def $name[..$tparams](...$paramss): $tpeopt = $expr"`
 Macro          | `q"..$mods def $name[..$tparams](...$paramss): $tpe = macro $expr"`
 Primary Ctor   | `q"..$mods def this(..$paramss)"`
 Secondary Ctor | `q"..$mods def this(..$paramss) = { this(...$aexprss); ..$stats }"`

## Template (meta.Template)

           | Quasiquote
-----------|--------------------
 Template  | `template"{ ..$stat } with ..$exprs { $param => ..$stats }"`

## Modifiers (meta.Mod)

                  | Quasiquote
------------------|-----------------
 Annotation       | `mod"@$expr"`
 Private          | `mod"private"`
 Private Within   | `mod"private[$str]"`
 Private This     | `mod"private[this]"`
 Protected        | `mod"protected"`
 Protected Within | `mod"protected[$str]"`
 Protected This   | `mod"protected[this]"`
 Implicit         | `mod"implicit"`
 Final            | `mod"final"`
 Sealed           | `mod"sealed"`
 Override         | `mod"override"`
 Case             | `mod"case"`
 Abstract         | `mod"abstract"`
 Covariant        | `mod"+"`
 Contravariant    | `mod"-"`
 Lazy             | `mod"lazy"`
 Val              | `mod"val"`
 Var              | `mod"var"`

## Enumerators (meta.Enum)

           | Quasiquote
-----------|------------------------------
 Generator | `enumerator"$pat <- $expr"`
 Value     | `enumerator"$pat = $expr"`
 Guard     | `enumerator"if $expr"`

## Importees (meta.Importee)

           | Quasiquote
-----------|---------------------------
 Name      | `importee"$str"`
 Rename    | `importee"$str => $str"`
 Unimport  | `importee"$str => _"`
 Wildcard  | `importee"_"`

## Cases (meta.Case)

      | Quasiquote
------|---------------------------
 Case | `p"$pat if $condopt => ..$stat"`

## Naming conventions

### Shorthands and interpolators

 Type                | Shorthand     | Interpolator
---------------------|---------------|--------------
 meta.Case           | `$case`       | `p`
 meta.Ctor.Ref       | `$ctorref`    | `ctor`
                     | `$ctorname`   | `ctor`
 meta.Enumerator     | `$enumerator` | `enumerator`
 meta.Member         | `$member`     | `q`
 meta.Mod            | `$mod`        | `mod`
 meta.Pat            | `$pat`        | `p`
 meta.Pat.Arg        | `$apat`       | `p`
 meta.Importee       | `$importee`   | `importee`
 meta.Stat           | `$stat`       | `q`
 meta.Template       | `$template`   | `template`
 meta.Term           | `$expr`       | `q`
 meta.Term.Arg       | `$aexpr`      | `arg`
 meta.Term.Name      | `$name`       | `q`
 meta.Term.Ref       | `$ref`        | `q`
 meta.Term.Param     | `$param`      | `param`
 meta.Type           | `$tpe`        | `t`
 meta.Type.Arg       | `$atpe`       | `t`
 meta.Type.Name      | `$tname`      | `t`
 meta.Type.Param     | `$tparam`     | `tparam`
                     | `$lit`        | `q`

### Suffix name modifiers

 Suffix | Wrapped Type  | Example
--------|---------------|-----------------------------
 -s     | `Seq[_]`      | `exprs: Seq[meta.Term]`
 -ss    | `Seq[Seq[_]]` | `exprss: Seq[Seq[meta.Term]]`
 -opt   | `Option[_]`   | `expropt: Option[meta.Term]`
