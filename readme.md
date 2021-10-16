# sbtnatimage

This is a simple scala project mainly intended to exercise
<https://github.com/scalameta/sbt-native-image>
and along with GitHub Actions to create binary releases
for Linux, macOS, and Windows.

The general setup here is rather adhoc, but it may still be useful to someone out there.

---

On your host machine:

      $ sbt

      > nativeImage

      > nativeImageRun
      my source location: /Users/carueda/github/mbari-org/sbtnatimage/out/sbtnatimage

      > ^D

      $ out/sbtnatimage
      my source location: /Users/carueda/github/mbari-org/sbtnatimage/out/sbtnatimage



Release workflow: [.github/workflows/native.yml](.github/workflows/native.yml)

Some notes:

- Tip: Consider adding [UPX](https://upx.github.io/) into the workflow.

- The linux executable will be statically linked.
  Just remove the `--static` option for a dynamically linked one.
  (Or, create both artifacts depending on your needs, etc.)
  
- The macOS executable won't be signed; so, upon downloading it, the user 
  will need to do something like the following to be able to run it:
  
        xattr -d com.apple.quarantine sbtnatimage

- Windows executable untested.
