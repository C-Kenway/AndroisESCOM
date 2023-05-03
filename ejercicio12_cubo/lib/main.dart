import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  double _rx = 0.0, _ry = 0.0, _rz = 0.0;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onPanUpdate: (details) {
        setState(() {
          _rx %= pi * 2;
          _ry %= pi * 2;
        });
      },
      child: Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Transform(
              transform: Matrix4.identity()
                ..setEntry(3, 2, 0.001)
                ..rotateX(_rx)
                ..rotateY(_ry)
                ..rotateZ(_rz),
              alignment: Alignment.center,
              child: Center(child: Cube()),
            ),
            const SizedBox(
              height: 32,
            ),
            Slider(
                value: _rx,
                min: pi * -2,
                max: pi * 2,
                onChanged: (value) => setState(() => setState(() {
                      _rx = value;
                    }))),
            Slider(
                value: _ry,
                min: pi * -2,
                max: pi * 2,
                onChanged: (value) => setState(() {
                      _ry = value;
                    })),
            Slider(
                value: _rz,
                min: pi * -2,
                max: pi * 2,
                onChanged: (value) => setState(() {
                      _rz = value;
                    })),
          ],
        ),
      ),
    );
  }
}

class Cube extends StatelessWidget {
  const Cube({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Stack(
      children: [
        Transform(
            transform: Matrix4.identity()..translate(0.0, 0.0, -100.0),
            alignment: Alignment.center,
            child: Container(
              color: Colors.orange.withOpacity(0.8),
              width: 200,
              height: 200,
            )),
        Transform(
            transform: Matrix4.identity()
              ..translate(100.0, 0.0, 0.0)
              ..rotateY(-pi / 2),
            alignment: Alignment.center,
            child: Container(
              color: Colors.amber.withOpacity(0.8),
              width: 200,
              height: 200,
            )),
        Transform(
            //Esta es la cara de abajo
            transform: Matrix4.identity()
              ..translate(0.0, 100.0, 0.0)
              ..rotateX(-pi / 2),
            alignment: Alignment.center,
            child: Container(
              color: Colors.green.withOpacity(0.8),
              width: 200,
              height: 200,
            )),
        Transform(
            transform: Matrix4.identity()
              ..translate(-100.0, 0.0, 0.0)
              ..rotateY(-pi / 2),
            alignment: Alignment.center,
            child: Container(
              color: Colors.purple.withOpacity(0.8),
              width: 200,
              height: 200,
            )),
        Transform(
            transform: Matrix4.identity()..translate(0.0, 0.0, 100.0),
            alignment: Alignment.center,
            child: Container(
              color: Colors.brown.withOpacity(0.8),
              width: 200,
              height: 200,
            )),

        //TOP
        Transform(
            transform: Matrix4.identity()
              ..translate(0.0, -100.0, 0.0)
              ..rotateX(pi / 2),
            alignment: Alignment.center,
            child: Container(
              color: Colors.teal.withOpacity(0.8),
              width: 200,
              height: 200,
            ))
      ],
    );
  }

  _buildFace() {
    return Transform(
        transform: Matrix4.identity()
          ..translate(0.0, 100.0, 0.0)
          ..rotateX(-pi / 2),
        alignment: Alignment.center,
        child: Container(
          color: Colors.green.withOpacity(0.8),
          width: 200,
          height: 200,
        ));
  }
}
