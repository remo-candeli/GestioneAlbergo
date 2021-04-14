package org.corso.albergo;

public class Camera {
    
    private String nrCamera;
    
    public Camera() {

    }

    public Camera(String nrCamera) {
        this.nrCamera = nrCamera;
    }

    public String getNrCamera() {
        return nrCamera;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nrCamera == null) ? 0 : nrCamera.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Camera other = (Camera) obj;
        if (nrCamera == null) {
            if (other.nrCamera != null)
                return false;
        } else if (!nrCamera.equals(other.nrCamera))
            return false;
        return true;
    }

    
}
