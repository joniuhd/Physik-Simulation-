// Szene erstellen
const scene = new THREE.Scene();

// Kamera erstellen
const camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);

// Renderer erstellen
const renderer = new THREE.WebGLRenderer();
renderer.setSize(window.innerWidth, window.innerHeight);
document.getElementById('3d-viewer').appendChild(renderer.domElement);

// Licht hinzufügen
const light = new THREE.AmbientLight(0x404040); // weiches Umgebungslicht
scene.add(light);

// Mikroskopbasis als Zylinder erstellen
const geometryBase = new THREE.CylinderGeometry(5, 5, 2, 32);
const materialBase = new THREE.MeshStandardMaterial({ color: 0x555555 });
const base = new THREE.Mesh(geometryBase, materialBase);
base.position.y = -1;
scene.add(base);

// Mikroskopobjektiv als Zylinder erstellen
const geometryLens = new THREE.CylinderGeometry(1, 1, 3, 32);
const materialLens = new THREE.MeshStandardMaterial({ color: 0x0000ff });
const lens = new THREE.Mesh(geometryLens, materialLens);
lens.position.y = 1;
scene.add(lens);

// Mikroskopstativ erstellen
const geometryStand = new THREE.CylinderGeometry(0.5, 0.5, 10, 32);
const materialStand = new THREE.MeshStandardMaterial({ color: 0x888888 });
const stand = new THREE.Mesh(geometryStand, materialStand);
stand.position.y = 5;
scene.add(stand);

// Kamera-Position
camera.position.z = 20;

// Steuerung für die Interaktivität hinzufügen (OrbitControls)
const controls = new THREE.OrbitControls(camera, renderer.domElement);

// Fenstergröße anpassen
window.addEventListener('resize', () => {
    renderer.setSize(window.innerWidth, window.innerHeight);
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();
});

// Animationsloop
function animate() {
    requestAnimationFrame(animate);

    // Hier könnten weitere Animationen oder Interaktionen hinzugefügt werden

    controls.update(); // für interaktive Steuerung

    renderer.render(scene, camera);
}

animate();
